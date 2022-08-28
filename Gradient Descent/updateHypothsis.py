def updateHypothsis(Hypothesis, alpha, Gradient):
    for i in range(len(Gradient)):
        Hypothesis[i] = Hypothesis[i] - alpha * Gradient[i]
    return Hypothesis