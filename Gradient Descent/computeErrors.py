import numpy as np
from predictValue import *

def computeErrors(data, prediction, Hypotesis):
    m = len(data)
    err = np.empty([m], dtype = float)
    if m == len(prediction):
        for i in range(m):
            err[i] = (predictValue(data[i], Hypotesis)-prediction[i])
    return err.reshape((m, 1))          # returns 1 column array