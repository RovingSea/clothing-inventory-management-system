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
public class Storehouse extends Model<Storehouse> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓库名
     */
    private String name;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
