import pandas as pd
df = pd.read_csv("trigo-serie-1923-2020-anual.csv")
dfindex=df.set_index("indice_tiempo")
dfsinduplicados=dfindex.drop_duplicates()
dfsinvacio=dfsinduplicados.dropna()
df1=dfsinvacio.iloc[0:30]
i1=len(dfsinvacio)-21
i2=len(dfsinvacio)-1
df2=dfsinvacio.iloc[i1:i2]
dff=pd.concat([df1,df2])
print(dff)
print(df1.iloc[[1,5,12,29]])
print(list(dfsinvacio.columns))
print(dfsinvacio['superficie_sembrada_trigo_ha'])

