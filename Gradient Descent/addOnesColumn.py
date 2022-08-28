import numpy as np
def addOnesColumn(data):
    data = np.c_[np.ones(len(data)), data]
    return data