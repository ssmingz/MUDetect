package de.tu_darmstadt.stg.mudetect.ranking;

import de.tu_darmstadt.stg.mudetect.mining.Model;
import de.tu_darmstadt.stg.mudetect.model.Overlap;
import de.tu_darmstadt.stg.mudetect.model.Overlaps;

public class ConfidenceWeightFunction implements ViolationWeightFunction {
    @Override
    public double getWeight(Overlap violation, Overlaps overlaps, Model model) {
        double patternSupport = violation.getPattern().getSupport();
        double patternViolations = overlaps.getViolationsOfSamePattern(violation).size();
        return patternSupport / (patternSupport + patternViolations);
    }

    @Override
    public String getFormula(Overlap violation, Overlaps overlaps, Model model) {
        int patternSupport = violation.getPattern().getSupport();
        int patternViolations = overlaps.getViolationsOfSamePattern(violation).size();
        return String.format("%d / (%d + %d)", patternSupport, patternSupport, patternViolations);
    }
}