def fibonacci_head(n):
    print(f'Calling fibonacci for n={n}')
    # Base Cases
    if n == 0:
        return 0
    if n == 1:
        return 1

    # Recursive Call
    sub_result1 = fibonacci_head(n-1)
    sub_result2 = fibonacci_head(n-2)

    # Operation
    result = sub_result1+sub_result2
    print(f'For n={n}: {sub_result1} + {sub_result2} = {result}')

    return result


print(fibonacci_head(5))

def fibonacci_tail(n, a=0, b=1):
    print(f'Calling fibonacci for n={n}')

    # Base Cases
    if n == 1:
        return b
    
    # Operation
    result = a+b
    print(f'For n={n}: {a} + {b} = {result}')

    # Recursive Call
    return fibonacci_tail(n-1, b, result)

print(fibonacci_tail(7))

    