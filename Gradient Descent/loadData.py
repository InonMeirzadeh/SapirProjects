import numpy as np
import matplotlib.pyplot as plt

def loadData(fileName):
    # seperate date into 2 matrix: features goes to data, predicted value goes to prediction
    data = np.loadtxt(fileName, usecols=(0,-2))
    prediction = np.loadtxt(fileName, usecols=(-1))
    np.set_printoptions(suppress=True)
    print("\nread ", len(data), " rows\n")

    feature1 = data[:, 0]
    feature2 = data[:, 1]

    # 1st graph:
    # x: original price
    # y: new price
    plt.scatter(feature1, prediction)
    plt.xlabel("Original Price")
    plt.ylabel("New Price")
    plt.show()

    # 2nd graph:
    # x: device age
    # y: new price
    plt.scatter(feature2, prediction)
    plt.xlabel("Device Age")
    plt.ylabel("New Price")
    plt.show()

    return data, prediction