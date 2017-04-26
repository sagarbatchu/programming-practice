# Enter your code here. Read input from STDIN. Print output to STDOUT

#Second approach, reduced to one iteration over the list. Passes half the test cases
#Based on the insight that a number's contribution to the sum is based on
# its own value and its position in the list
#eg:
# Number   Unit  Tens Hundreds    sum
# 1        1     1    1           1 * 3 * 111
# 2        2     2                2 * 2 * 11
# 3        3                      3 * 3 * 1
                            # total= 383
import sys

balls = sys.stdin.readline()

def total(balls):
    sum = 0
    for idx,val in enumerate(balls):
        sum += int(val) * (idx+1) * int((len(balls)-idx)*'1')
    return sum

print(total(balls))


# First approach: dumb iteration, bad scaling
#
# def total(balls):
#     total = sum(combinations(balls))
#     return total
#
# def combinations(balls):
#     combos = []
#     for i in xrange(0,len(balls)):
#         for j in xrange(i,len(balls)):
#             combos.append(int(balls[i:j+1]))
#     return combos
#
# print(total(balls))
