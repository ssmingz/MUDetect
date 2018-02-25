package de.tu_darmstadt.stg.mudetect.aug.model.data;

import de.tu_darmstadt.stg.mudetect.aug.model.BaseNode;
import de.tu_darmstadt.stg.mudetect.aug.model.DataNode;
import de.tu_darmstadt.stg.mudetect.aug.visitors.NodeVisitor;

public class AnonymousClassMethodNode extends BaseNode implements DataNode {
    private final String methodSignature;

    public AnonymousClassMethodNode(String methodSignature) {
        this.methodSignature = methodSignature;
    }

    @Override
    public String getType() {
        return "<method>";
    }

    @Override
    public String getName() {
        return "<method>";
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getLabel() {
        return methodSignature;
    }
    
    @Override
    public <R> R apply(NodeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
