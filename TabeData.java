package whisc.test_1;

import android.provider.BaseColumns;

/**
 * Created by Connor on 11/6/2017.
 */

public class TabeData {

    public TabeData(){

    }

    public static abstract class TableInfo implements BaseColumns {
        public static final String USER_NAME = "user_name";
        public static final String USER_PASS = "user_pass";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "reg_info";

    }

}
