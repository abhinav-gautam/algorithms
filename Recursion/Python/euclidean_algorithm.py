def gcd(a, b):
    print(f'Calling gcd with a={a} b={b}')

    if a % b == 0:
        return b

    return gcd(b, a % b)


print(gcd(24, 9))
