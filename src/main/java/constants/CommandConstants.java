package constants;

import java.util.LinkedList;
import java.util.List;

public class CommandConstants {
    public static final String BILL = "bill";
    public static final String MENU = "menu";

    public static final String SHOW = "show";
    public static final String ADD = "add";
    public static final String CREATE = "create";
    public static final String EDIT = "edit";
    public static final String PAY = "pay";
    public static final String DELETE = "delete";
    public static final String ALL = "all";
    public static final String DETAILS = "details";

    public static final String FOOD = "food";
    public static final String DRINK = "drink";

    public static final String PARAM_PREFIX = "--";
    public static final String ID_PREFIX = PARAM_PREFIX + "id";
    public static final String NAME_PREFIX = PARAM_PREFIX + "name";
    public static final String PRICE_PREFIX = PARAM_PREFIX + "name";
    public static final String DESCRIPTION_PREFIX = PARAM_PREFIX + "description";
    public static final String TYPE_PREFIX = PARAM_PREFIX + "type";
    public static final String STATUS_PREFIX = PARAM_PREFIX + "status";
    public static final String QUANTITY_PREFIX = PARAM_PREFIX + "quantity";
    public static final List<String> ITEM_COMMAND_PARAMS = new LinkedList<>();
    public static final List<String> BILL_COMMAND_PARAMS = new LinkedList<>();

    static {
        ITEM_COMMAND_PARAMS.add(ID_PREFIX);
        ITEM_COMMAND_PARAMS.add(NAME_PREFIX);
        ITEM_COMMAND_PARAMS.add(PRICE_PREFIX);
        ITEM_COMMAND_PARAMS.add(DESCRIPTION_PREFIX);
        ITEM_COMMAND_PARAMS.add(TYPE_PREFIX);
        ITEM_COMMAND_PARAMS.add(STATUS_PREFIX);

        BILL_COMMAND_PARAMS.add(ID_PREFIX);
        BILL_COMMAND_PARAMS.add(STATUS_PREFIX);
    }
}
