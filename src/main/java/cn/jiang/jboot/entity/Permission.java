package cn.jiang.jboot.entity;

import cn.jiang.jboot.base.JbootBaseEntity;
import cn.jiang.jboot.base.JbootBaseEntity;
import cn.jiang.jboot.common.constant.CommonConstant;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

/**
 * 菜单/权限
 * @author jiang
 */
@Data
@Entity
@Table(name = "t_permission")
@TableName("t_permission")
public class Permission extends JbootBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单/权限名称")
    private String name;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "类型 0页面 1具体操作")
    private Integer type;

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "页面路径/资源链接url")
    @Column(nullable = false)
    private String path;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "按钮权限类型")
    private String buttonType;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "说明备注")
    private String description;

    @ApiModelProperty(value = "排序值")
    @Column(precision = 10, scale = 2)
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status = CommonConstant.STATUS_NORMAL;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "子菜单/权限")
    private List<Permission> children;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "页面拥有的权限类型")
    private List<String> permTypes;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "节点展开 前端所需")
    private Boolean expand = true;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "是否勾选 前端所需")
    private Boolean checked = false;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "是否选中 前端所需")
    private Boolean selected = false;
}