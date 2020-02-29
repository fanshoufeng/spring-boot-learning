package com.fanshoufeng.jpa.param;

import lombok.Getter;
import lombok.Setter;

public class UserDetailParam {

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private Integer minAge;

    @Getter
    @Setter
    private Integer maxAge;

    @Getter
    @Setter
    private String realName;

    @Getter
    @Setter
    private String introduction;

    @Getter
    @Setter
    private String city;

}
