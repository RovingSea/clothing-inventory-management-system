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
public class Storage extends Model<Storage> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货物id
     */
    private Integer clotesId;

    /**
     * 仓库id
     */
    private Integer storehouseId;

    /**
     * 总数
     */
    private Integer total;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
