package com.biggirlo.system.jopo.jstree;

public class Data {

    private Object id;//存放真正的id

    private TreeNodeType type;//节点类型

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public TreeNodeType getType() {
        return type;
    }

    public void setType(TreeNodeType type) {
        this.type = type;
    }
}
