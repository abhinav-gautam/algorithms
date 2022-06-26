def factorial_head(n):
    print(f'Calling factorial function with n={n}')

    # Base condition
    if n == 1:
        return 1

    # Recursive call
    sub_result = factorial_head(n-1)

    # Operation
    result = n * sub_result
    print(f'{n} * {sub_result}')

    return result


print(factorial_head(5))


def factorial_tail(n, accumulator=1):
    print(f'Calling factorial function with n={n}')

    # Base Condition
    if n == 1:
        return accumulator

    # Operation
    result = n*accumulator
    print(f'{n} * {accumulator}')

    # Recursive Call
    return factorial_tail(n-1, result)


print(factorial_tail(5))
