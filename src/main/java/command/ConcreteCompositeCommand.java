package command;

import constants.CommandConstants;
import entity.Bill;
import entity.Drink;
import entity.Food;
import exception.ApplicationException;
import service.BillServiceCore;
import service.ItemServiceCore;
import service.implement.BillService;
import service.implement.DrinkService;
import service.implement.FoodService;

import java.util.*;

public abstract class ConcreteCompositeCommand implements CompositeCommand {
    private static final String SPACE = "\\s";
    private static final String MULTI_SPACES = "\\s+";

    private ItemServiceCore<Food> foodService = FoodService.getInstance();
    private ItemServiceCore<Drink> drinkService = DrinkService.getInstance();
    private BillServiceCore<Bill> billService = BillService.getInstance();

    private List<CompositeCommand> subCommands = new LinkedList<>();
    private List<String> requiredParam = new LinkedList<>();
    private String name = "";
    private String command;

    @Override
    public void process() {

    }

    @Override
    public void validateCommand(String command, boolean isNeedParam) throws ApplicationException {
        // example: menu           show         food       --id=1
        //       rootcommand    subcommand     option      param
        String[] partsOfCommand = command.trim().split(getName(), 2);
        if (partsOfCommand.length != 2)
            throw new ApplicationException(ApplicationException.Reason.INVALID_OPTIONS, command);

        String[] optionAndParams = partsOfCommand[1].trim().split(MULTI_SPACES, 2);
        if ((optionAndParams.length == 2) && !isNeedParam)
            throw new ApplicationException(ApplicationException.Reason.INVALID_PARAMS, optionAndParams[1]);

        if ((optionAndParams.length == 1) && isNeedParam)
            throw new ApplicationException(ApplicationException.Reason.REQUIRED_PARAMS);
    }

    public List<String> getRequiredParam() {
        return requiredParam;
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<CompositeCommand> getSubCommands() {
        return subCommands;
    }

    @Override
    public void addSubCommand(CompositeCommand subCommand) {
        subCommands.add(subCommand);
    }

    public ItemServiceCore<Food> getFoodService() {
        return foodService;
    }

    public ItemServiceCore<Drink> getDrinkService() {
        return drinkService;
    }

    public BillServiceCore<Bill> getBillService() {
        return billService;
    }

    protected Map<String, String> getMapParams(String optionAndParamsString) throws ApplicationException {
        Map<String, String> result = new HashMap<>();

        String[] optionAndParams = optionAndParamsString.split(SPACE, 2);
        if (optionAndParams.length == 2) {
            String paramString = optionAndParams[1];
            String[] params = paramString.split(SPACE);
            for (String param : params) {
                String[] keyAndValue = param.split("=");
                if (keyAndValue.length == 2) {
                    String key = keyAndValue[0];
                    String value = keyAndValue[1];
                    addToMap(result, key, value);
                } else {
                    throw new ApplicationException(ApplicationException.Reason.INVALID_PARAMS, keyAndValue[0]);
                }
            }
        }

        if (result.size() > requiredParam.size())
            throw new ApplicationException(ApplicationException.Reason.REDUNDANT_PARAM, findRedundantParam(result));
        return result;
    }

    private void addToMap(Map<String, String> map, String key, String value) throws ApplicationException {
        validateParam(map, key, value);
        map.put(key, value);
    }

    private void validateParam(Map<String, String> map, String key, String value) throws ApplicationException {
        if (!CommandConstants.VALID_PARAM_PREFIX.contains(key))
            throw new ApplicationException(ApplicationException.Reason.INVALID_PARAMS, key);
        if (map.containsKey(key))
            throw new ApplicationException(ApplicationException.Reason.DUPLICATE_PARAM, key);
        if (CommandConstants.ID_PREFIX.equals(key) || CommandConstants.PRICE_PREFIX.equals(key)) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException exception) {
                throw new ApplicationException(ApplicationException.Reason.INVALID_PARAMS_VALUE, value);
            }
        }
    }

    protected String findRedundantParam(Map<String, String> currentParam) {
        StringJoiner stringJoiner = new StringJoiner(",");
        currentParam.keySet().stream().filter(key -> !requiredParam.contains(key)).forEach(stringJoiner::add);
        return stringJoiner.toString();
    }

    protected String getOptionCommand() throws ApplicationException {
        String[] partsOfCommand = getCommand().trim().split(getName(), 2);
        String option = partsOfCommand.length == 2 ? partsOfCommand[1] : null;

        if (option == null)
            throw new ApplicationException(ApplicationException.Reason.INVALID_OPTIONS, null);
        return option;
    }
}
