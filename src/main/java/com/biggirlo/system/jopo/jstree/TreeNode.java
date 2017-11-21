/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.system.jopo.jstree;

/**
 * 树节点对象
 * @author 王雁欣
 * create on 2017/10/30 1:35 
 */
public class TreeNode {
    public static final Long MENU = 1L;//菜单类型
    public static final Long INTERFACE = 2L;//接口类型
    //id
    private String id;

    //名字
    private String text;

    //父节点
    private String parent;

    //图标
    private String icon;

    //状态
    private TreeNodeState state;

    //是否被选中
    private boolean isSelect;

    //拓展字段，任何数据，设置这个属性没有任何UI上的效果，任何时候都可以读写这个数据.
    private Data data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public TreeNodeState getState() {
        return state;
    }

    public void setState(TreeNodeState state) {
        this.state = state;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    /**
     * 设置为被选择状态
     */
    public void setSelected() {
        if(this.state == null)
            this.state = new TreeNodeState();
        this.state.setSelected(true);
        this.state.setOpened(true);
    }

}
