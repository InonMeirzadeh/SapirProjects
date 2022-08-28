from computeErrors import *
def computeCost(data, prediction, Hypothesis):
    errors = computeErrors(data, prediction, Hypothesis)
    m = len(data)
    errSum = 0
    for i in range(m):
        errSum = errSum + errors[i]**2
    return errSum/(2*m), errors
