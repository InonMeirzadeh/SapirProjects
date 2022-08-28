from loadData import *
from normalizePrices import *
from addOnesColumn import *
from computeCost import *
from computeGradient import *
from updateHypothsis import *

def gradientDescent(fileName, alpha=0.1, max_iter=1000, threshold=0.001):
    cost_J = float('inf')
    iter = 1
    Costs = [cost_J]

    data, prediction = loadData(fileName)

    normalizePrices(data)

    data = addOnesColumn(data)
    Hypothesis = np.zeros(len(data[0]))

    while True:
        cost, Errors = computeCost(data, prediction, Hypothesis)
        Gradient = computeGradient(data, Errors)
        Hypothesis = updateHypothsis(Hypothesis, alpha, Gradient)
        if cost_J - cost < threshold or iter == max_iter:
            if iter == max_iter:
                print("Gradient descent terminating after {0} iterations (max_iter)".format(max_iter))
            else:
                diff = threshold-(cost_J-cost)
                print("Gradient descent terminating after {0} iterations. Improvement was : {1} below threshold ({2})".format(iter, diff[0], threshold))
            break
        Costs.append(cost[0])
        cost_J = cost[0]
        iter += 1

    plt.scatter(np.arange(iter), np.array(Costs))
    plt.xlabel("Iteration")
    plt.ylabel("Cost")
    plt.show()

    return Hypothesis, np.array(Costs)