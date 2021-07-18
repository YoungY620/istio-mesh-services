package cn.yy.javaservicev2.dto.relation;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yy
 * @since 2021-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    private String conId;

    private String conCustomerId;

    private String conName;

    private String conDept;

    private String conRole;

    private String conLandlinePhone;

    private String conMobilePhone;

    private String conFax;

    private String conEmail;

    private String conQq;

    private String conWechat;


}
