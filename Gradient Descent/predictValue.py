def predictValue(vec, Hypothesis):
    # calculates sum of elements of the current sample times the current hypothesis
    return sum(vec*Hypothesis)