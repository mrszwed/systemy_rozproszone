import os
import numpy as np
import re
import matplotlib.pyplot as plt

def mean_std_without_outliers(x):
    mean=x.mean()
    std=x.std()
    z=x[np.abs(x-mean)<3*std]
    return z.mean(), z.std()

sekwencje={}
pojedyncze={}

dir = r'C:\ms\AGH-Informatyka\sem6\systemy rozproszone\lab-middleware1\I1\wyniki-thrift'
files = os.listdir(dir)
for f in files:
    print(f)
    m = re.match(r'([A-Za-z]+)(\d+)', f)
    if m:
        m.groups()
        x=np.loadtxt(dir+"\\"+f, skiprows=1)
        key=m.groups()[0]
        data = sekwencje.get(key, [])
        mean,std=mean_std_without_outliers(x)
        data.append((int(m.groups()[1]), mean, std))
        sekwencje[key]=data
        continue
    x = np.loadtxt(dir + "\\" + f, skiprows=1)
    mean, std = mean_std_without_outliers(x)
    m=re.match(r'([A-Za-z]+)', f)
    key=m.groups()[0]
    data = pojedyncze.get(key, [])
    data.append((mean, std))
    pojedyncze[key]=data
print(sekwencje)
print(pojedyncze)
for k in pojedyncze:
    print(k,end='\t')
print()
for k in pojedyncze:
    print(f"{pojedyncze[k][0][0]:.3g}",end='\t')
print()
for k in pojedyncze:
    print(f"{pojedyncze[k][0][1]:.3g}",end='\t')
print()

#person sequence
data=sekwencje["PersonSequence"]
x=np.array(data)
# print(x)
# print(np.argsort(x[:,0],axis=0))
x=x[x[:, 0].argsort()]
plt.plot(x[:,0], x[:,1],label='PersonSeq')
plt.scatter(x[:,0], x[:,1])

data=sekwencje["FiveDoublesSequence"]
x=np.array(data)
# print(x)
# print(np.argsort(x[:,0],axis=0))
x=x[x[:, 0].argsort()]
plt.plot(x[:,0], x[:,1],label='FiveDoublesSeq')
plt.scatter(x[:,0], x[:,1])

data=sekwencje["MixedSequence"]
x=np.array(data)
# print(x)
# print(np.argsort(x[:,0],axis=0))
x=x[x[:, 0].argsort()]
plt.plot(x[:,0], x[:,1],label='MixedSeq')
plt.scatter(x[:,0], x[:,1])



plt.xlabel("Length")
plt.ylabel("Time")
plt.legend()
plt.title("Thrift")
plt.show()