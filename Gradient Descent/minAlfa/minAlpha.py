from Assignment1 import *

minAlpha = 1
check = 0
addF = 0.1
threshold = 0.1
minThreshold = 0.1
minCost = float('inf')
for l in range(1, 15):
    for j in range(1, 20):
        for i in range(2, 10):
            Hypothesis, Costs = gradientDescent("smartphone.txt", check, 5000, threshold)
            checkCost = Costs[-1]
            if checkCost < minCost:
                minCost = checkCost
                minAlpha = check
                minThreshold = threshold
            check += addF
        check = minAlpha
        addF = addF / 10
    threshold = threshold/10
print(minAlpha)
print(minCost)
print(minThreshold)