def head(n):
    print(f'Calling head with n={n}')

    # Base Condition
    if n == 0:
        return

    # Operation
    print(n)

    # Recursive Call
    head(n-1)


head(5)


def tail(n):
    print(f'Calling tail with n={n}')

    # Base Condition
    if n == 0:
        return

    # Recursive Call
    tail(n-1)

    # Operation
    print(n)


tail(5)
