package constants;

import java.util.LinkedList;
import java.util.List;

public class CommandConstants {
    public static final String BILL = "bill";
    public static final String MENU = "menu";

    public static final String SHOW = "show";
    public static final String ADD = "add";
    public static final String EDIT = "edit";
    public static final String DELETE = "delete";
    public static final String ALL = "all";

    public static final String FOOD = "food";
    public static final String DRINK = "drink";

    public static final String PARAM_PREFIX = "--";
    public static final String ID_PREFIX = PARAM_PREFIX + "id";
    public static final String NAME_PREFIX = PARAM_PREFIX + "name";
    public static final String PRICE_PREFIX = PARAM_PREFIX + "name";
    public static final List<String> VALID_PARAM_PREFIX = new LinkedList<>();

    static {
        VALID_PARAM_PREFIX.add(ID_PREFIX);
        VALID_PARAM_PREFIX.add(NAME_PREFIX);
    }
}
