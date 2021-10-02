package database.hikari;

import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午10:40
 * @description User
 */
@Data
public class User {

    private String id;

    private String name;

    private String birthday;
}
