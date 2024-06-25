"""
# Exercício
Baixe a base de dados de QI por país e investigue:
1.   qual o QI médio a nível mundial?
2.   qual o QI médio por continente?
3.   plote o gráfico de QI por país
4.   existe alguma correlação aparente entre QI e BLI ou GDP, investigados nos exemplos anteriores? Use JOIN.

QI - arquivo CSV:<br>
**https://worldpopulationreview.com/country-rankings/average-iq-by-country**
"""
import pandas as pd

#EX1

df_IQ.loc[:, 'averageIqByCountry_iqLynnBecker2019' ].mean()

#EX2
df_EX2 = df_IQ.set_index('country').join(df_CONTINENTS.set_index('Country'), how = 'inner')
df_EX2 = df_EX2[['Continent','averageIqByCountry_iqLynnBecker2019']]

df_AFRICA = df_EX2 [ df_EX2['Continent'] == 'Africa' ]
df_AFRICA.loc[:, 'averageIqByCountry_iqLynnBecker2019' ].mean()

df_ASIA = df_EX2 [ df_EX2['Continent'] == 'Asia' ]
df_ASIA.loc[:, 'averageIqByCountry_iqLynnBecker2019' ].mean()

df_EUROPE = df_EX2 [ df_EX2['Continent'] == 'Europe' ]
df_EUROPE.loc[:, 'averageIqByCountry_iqLynnBecker2019' ].mean()

df_NORTH_AMERICA = df_EX2 [ df_EX2['Continent'] == 'North America' ]
df_NORTH_AMERICA.loc[:, 'averageIqByCountry_iqLynnBecker2019' ].mean()

df_OCEANIA = df_EX2 [ df_EX2['Continent'] == 'Oceania' ]
df_OCEANIA.loc[:, 'averageIqByCountry_iqLynnBecker2019' ].mean()

df_SOUTH_AMERICA = df_EX2 [ df_EX2['Continent'] == 'South America' ]
df_SOUTH_AMERICA.loc[:, 'averageIqByCountry_iqLynnBecker2019' ].mean()

#EX3

df_EX3 = df_IQ.set_index('country')
df_EX3[['averageIqByCountry_iqLynnBecker2019']].plot()

#EX4

df_EX4 = df_IQ.set_index('country').join(df_BLI.set_index('Country'), how = 'inner')
df_EX4 = df_EX4.set_index('LOCATION').join(df_GDP.set_index('Country Code'), how = 'inner')
df_EX4 = df_EX4[['averageIqByCountry_iqLynnBecker2019', 'AverageIQ_ICI2017Score', 'OverallPisaScore2022', 'PISAScoresMathScore2022', 'PISAScoresScienceScore2022', 'PISAScoresReadingScore2022', '1990','1991','1992','1993','1994','1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017','2018','2019' ]]
df_EX4.corr()