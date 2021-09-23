def cipher_plus(n):
    result = 0
    while n:
        result += (n % 10) ** 2
        n = int(n / 10)
        # print(result)
    return result


def solution(n):
    init = n
    while 1:
        n = cipher_plus(n)
        if n == 1 or n == 4 :
            break
    if n == 1:
        print(init, "is Happy Number.")
    else:
        print(init, "is Unhappy Number.")
    return



n = int(input())
solution(n)

