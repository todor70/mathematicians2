package com.zeljko.mathematicians2.domain;

import java.util.ArrayList;
import java.util.List;

public class MathematicianList {

   private List<Mathematician> mathematicians;

    public MathematicianList() {
        mathematicians = new ArrayList<>();
    }

    public List<Mathematician> getMathematicians() {
        return mathematicians;
    }

    public void setMathematicians(List<Mathematician> mathematicians) {
        this.mathematicians = mathematicians;
    }
}