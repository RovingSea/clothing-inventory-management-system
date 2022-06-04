package edu.ccsu.grade19.wu.cims.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class WarehousingOrder extends Model<WarehousingOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 入库单
     */
    private String oddNumbers;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 仓库id
     */
    private Integer storehouseId;

    /**
     * 入库日期
     */
    private LocalDateTime date;

    /**
     * 数量
     */
    private Integer amount;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
