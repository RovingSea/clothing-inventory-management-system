package edu.ccsu.grade19.wu.cims.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Haixin Wu
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 增加权限
     */
    private Boolean addPermission;

    /**
     * 删除权限
     */
    private Boolean deletePermission;

    /**
     * 修改权限
     */
    private Boolean modifyPermission;

    /**
     * 查询权限
     */
    private Boolean queryPermission;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
