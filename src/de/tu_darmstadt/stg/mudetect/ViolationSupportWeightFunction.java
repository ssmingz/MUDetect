package de.tu_darmstadt.stg.mudetect;

import de.tu_darmstadt.stg.mudetect.model.Instance;
import de.tu_darmstadt.stg.mudetect.model.Overlaps;

public class ViolationSupportWeightFunction implements ViolationWeightFunction {
    @Override
    public float getWeight(Instance violation, Overlaps overlaps, Model model) {
        float numberOfEqualViolations = 0;
        for (Instance otherViolation : overlaps.getViolationsOfSamePattern(violation)) {
            // two overlaps are equal, if they violate the same aPatternBuilder in the same way,
            // i.e., if the aPatternBuilder overlap is the same.
            if (violation.isSamePatternOverlap(otherViolation)) {
                numberOfEqualViolations++;
            }
        }
        return 1 / numberOfEqualViolations;
    }
}
