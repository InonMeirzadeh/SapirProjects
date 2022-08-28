# Assignment 1
# Tom Basha - 311425714
# Inon Meirzadeh - 315858399

from gradientDescent import *

alpha = 0.12760717777760003
threshold = 0.000000000001
Hypothesis, Costs = gradientDescent("smartphone.txt", alpha, 5000, threshold)

print("\nThe final hypothesis is: ", Hypothesis)
print("\nD) In order to find the best Alpha (= ", alpha, "), we wrote a function that calculates the optimal threshold and alpha, without capping the iterations."
      "\n * The function calculates alpha for threshold from 0.1 to 0.0000000000000001."
      "\n * The alpha we check starts from 1 digit after the decimal point (0.x) all the way to 20 digits after the decimal point (0.xxxxxxxxxxxxxxxxxxxx), \n   for every digit we try every number from 0 - 9 to find the best result and the lowest cost."
      "\n\nThe function located in minAlpha.py which provided with the assignment in a separate folder called minAlpha.")