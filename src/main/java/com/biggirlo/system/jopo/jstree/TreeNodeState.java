/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.system.jopo.jstree;

/**
 * 树节点状态
 * @author 王雁欣
 * create on 2017/11/6 20:08 
 */
public class TreeNodeState {

    //是否选择
    private boolean selected;

    //打开状态
    private boolean opened;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

}
