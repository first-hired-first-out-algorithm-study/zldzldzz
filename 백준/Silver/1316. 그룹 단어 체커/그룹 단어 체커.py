N=int(input())#배열 개수
count=0
check=[]
for i in range(N):
    word=input()
    check=[]
    for I in range(len(word)):
        if(len(word)==1):
            count += 1
            break
        k=word[I]
        if (k not in check)or(check[-1]==word[I]):
            check.append(word[I])
    if (check==list(word)):
        count+=1

print(count)
