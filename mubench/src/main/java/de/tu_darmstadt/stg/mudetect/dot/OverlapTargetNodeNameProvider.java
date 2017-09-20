package de.tu_darmstadt.stg.mudetect.dot;

import de.tu_darmstadt.stg.mudetect.aug.model.Node;
import de.tu_darmstadt.stg.mudetect.aug.model.dot.AUGNodeLabelProvider;
import de.tu_darmstadt.stg.mudetect.model.Overlap;
import org.jgrapht.ext.VertexNameProvider;

class OverlapTargetNodeNameProvider implements VertexNameProvider<Node> {
    private static final AUGNodeLabelProvider TARGET_AUG_NODE_NAME_PROVIDER = new AUGNodeLabelProvider();

    private final Overlap overlap;

    OverlapTargetNodeNameProvider(Overlap overlap) {
        this.overlap = overlap;
    }

    @Override
    public String getVertexName(Node patternNode) {
        StringBuilder label = new StringBuilder();
        if (overlap.mapsNode(patternNode)) {
            Node targetNode = overlap.getMappedTargetNode(patternNode);
            label.append(TARGET_AUG_NODE_NAME_PROVIDER.getVertexName(targetNode));
        } else {
            label.append(patternNode.getLabel());
        }
        return label.toString();
    }
}