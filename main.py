"""import pandas as pd

Survey = {
    "No": [1000, 2000, 3000],
    "Yes": [400, 500, 600]
}
df = pd.DataFrame(Survey)
print(df)
df.plot(kind='bar',color='red')
df_normalized = (df-df.mean())/df.std()
print(df_normalized)
df_normalized.plot(kind='bar',color='blue')
normalized_df = df.apply(lambda x:(x-x.mean())/x.std(),axis=0)
print("Normalized Data Method 2")
print(normalized_df)
normalized_df.plot(kind="bar",color='green')

"""
"""
import pandas as pd
import matplotlib.pyplot as plt

# Creating a DataFrame from the survey data
Survey = {
    "No": [1000, 2000, 3000],
    "Yes": [400, 500, 600]
}
df = pd.DataFrame(Survey)

# Displaying the original DataFrame
print("Original Data:")
print(df)

# Plotting the original DataFrame
df.plot(kind='bar', color='red')
plt.title('Original Data')
plt.show()

# Normalizing the DataFrame using z-score
df_normalized = (df - df.mean()) / df.std()

# Displaying the normalized DataFrame
print("\nNormalized Data Method 1:")
print(df_normalized)

# Plotting the normalized DataFrame
df_normalized.plot(kind='bar', color='blue')
plt.title('Normalized Data Method 1')
plt.show()

# Normalizing the DataFrame using a lambda function
normalized_df = df.apply(lambda x: (x - x.mean()) / x.std(), axis=0)

# Displaying the normalized DataFrame using the lambda function
print("\nNormalized Data Method 2:")
print(normalized_df)

# Plotting the normalized DataFrame using the lambda function
normalized_df.plot(kind="bar", color='green')
plt.title('Normalized Data Method 2')
plt.show()
"""
"""import pandas as pd
import random

color = ["balck", "Grey", "Brown", "blue"]
size = [32, 34, 42, 44, 38]
df = {"Id's": [],
      "color": [],
      "Size": []
      }
for i in range(1, 1001):
    df["Id's"].append(int("100" + str(i)))
    df["color"].append(random.choice(color))
    df["Size"].append(random.choice(size))
df = pd.DataFrame(df)
print(df)"""

import pandas as pd
import random

rank = ["Outstanding", "first class", "Second Class", "Pass Class", "Third Class"]
Age = [18, 19, 17, 21, 20]
Gender = ['M', 'F']
df = {
    "Age": random.choices(Age, k=10),
    "Gender": random.choices(Gender, k=10),
    "Rank": random.choices(rank, k=10)
}
df = pd.DataFrame(df)
print(df)
cross = df[df["Rank"] == "Outstanding"]
print(cross)
x = lambda a, b: a + b
print(x(2, 4))
