import math
fee = [2,1,3,1,2]
def stairway_to_heaven2(fee):
    min_fee = [0 for i in range(len(fee))]
    min_fee[1] = fee[0]
    min_fee[2] = fee[0]
    for i in range(3,len(fee)):
        min_fee[i] = min(fee[i-1]+min_fee[i-1],fee[i-2]+min_fee[i-2],fee[i-3]+min_fee[i-3])
    print(min_fee)
stairway_to_heaven2(fee)