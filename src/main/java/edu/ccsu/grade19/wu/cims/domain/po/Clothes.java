package edu.ccsu.grade19.wu.cims.domain.po;

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
public class Clothes extends Model<Clothes> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货号
     */
    private String articleNo;

    /**
     * 货名
     */
    private String name;

    /**
     * 色号
     */
    private String colority;

    /**
     * 尺码
     */
    private Integer size;

    /**
     * 来源
     */
    private String from;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
