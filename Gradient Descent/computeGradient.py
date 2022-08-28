import numpy as np
def computeGradient(data, Errors):
    m = len(data)
    gradient = np.zeros(len(data[0]))
    for j in range(len(gradient)):              # num of features
        for i in range(m):                      # num of samples
            gradient[j] = gradient[j] + data[i][j] * Errors[i]
        gradient[j] = gradient[j]/m

    return gradient