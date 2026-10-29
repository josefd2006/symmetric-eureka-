# -*- coding: utf-8 -*-
"""
Created on Wed Oct  5 09:08:36 2022

@author: Marcia Moraes
"""
info1 ={
        'genre': 'Fantasy Commedy',
        'year': 1991,
        'cast': ['Anjelica Huston', 'Raul Julia', 'Christopher Lloyd']
        }
info2 ={
        'genre': 'Fantasy Commedy',
        'year': 1993,
        'cast': ['Bette Midler', 'Sarah Jessica Parker', 'Kathy Najimy'] 
        }
info3 = {
        'genre': "Horror Commedy",
        'year': 2003,
        'cast': ['Eddie Murphy', 'Terence Stamp', 'Wallace Shawn', 'Marsha Thomason', 'Jennifer Tilly']
        }

halloween = {
    'The Addams Family': info1,
    'Hocus Pocus': info2,
    'The Haunted Mansion': info3,
    }

def returnFilmTitles():
    '''
    Returns a string containing the film titles in the halloween
    dictionary. Considering the initial partial implementation 
    provided as well as the initial provided content for halloween
    dictionary, when you print the string returned you will have
    the following output printed in your console:
    Film Titles
    1:The Addams Family
    2:Hocus Pocus
    3:The Haunted Mansion
        

    Returns
    -------
    msg : string
        

    '''
    msg = 'Film Titles\n'
    titles = halloween.keys()
    count = 0
    for i in titles:
        count += 1
        msg += f"{count}:{i}\n"
    return msg
    
   


def searchFilm(title):
    '''
    Search for a film by its title in the halloween dictionary
    and returns a string containing all the information of that
    film. 

    Parameters
    ----------
    title : string
        title of the film.

    Returns
    -------
    film : string
    If the title is not in the hallowwen dictionary, the method
    should return an empty string.
    If the title is in the halloween dictionary, the information should be returned in the following 
    format:
    Title: <title of the film passed as a parameter>
    Genre: <genre of the film which title passed as a parameter>
    Year: <year of the film which title passed  as a parameter>
    Cast:
    1: <name of the first person in the cast list for the title passed as a parameter>
    2: <name of the second person in the cast list for the title passed as a parameter>
    ...
    #: <name of the last person in the cast list for the title passed as a parameter>
    
    For example, if title is "The Haunted Mansion"
    When you print the string generated you will have the following:
    Title:The Haunted Mansion
    Genre:Horror Commedy
    Year:2003
    Cast:
    1:Eddie Murphy
    2:Terence Stamp
    3:Wallace Shawn
    4:Marsha Thomason
    5:Jennifer Tilly

    '''
    film = ''
    if title in halloween.keys():
        film += f"Title:{title}\n"
        info = halloween[title]
        film += f"Genre:{info['genre']}\n"
        film += f"Year:{info['year']}\n"
        actors = info['cast']
        count = 0
        film += "Cast:\n"
        for actor in actors:
            count += 1
            film += f"{count}:{actor}\n"
        return film 
    else:
        return film 

    
    

def addFilm(title, genre, year, cast):
    info = {
        'genre':genre,
        'year': year,
        'cast': cast
            }
    halloween[title] = info

def removeFilm(title):
    '''
    Remove film with title from the halloween dictionary.
    If the film is not in the halloween dictionary, return 
    and empty string.
    If the film is in the halloween dictionary, return
    the value of the key that is being removed.

    Parameters
    ----------
    title : string
        title of the film.

    Returns
    -------
    empty string or the value of the key that is being removed
        If the film is not in the halloween dictionary, return 
        and empty string.
        If the film is in the halloween dictionary, return
        the value of the key that is being removed..

    '''
    if title in halloween.keys():
        removed = halloween[title]
        halloween.pop(title)
        return removed
    else:
        return ''

def recursion(num, exp):
    '''
    Implement a recursive function that 
    return the value of num in the power
    of exp. For example, if num is 3 and exp is 2,
    the function will return 3 in the power of 2,
    which is 9.

    Parameters
    ----------
    num : integer
        
    exp : integer
        

    Returns
    -------
    integer
        result of num in the power of exp.

    '''
    if exp == 0:
        return 1
    else:
        return num * recursion(num, exp - 1)
    
    

def main():
    msg = returnFilmTitles()
    print(msg)
    
    title = searchFilm("The Haunted Mansion")
    if title != '':
        print(title)
    else: print("Film not found")
   
    title = searchFilm("The Haunted Mansion 2")
    if title != '':
        print(title)
    else: print("Film not found")
    
    addFilm("Hocus Pocus 2", "Fantasy Commedy", 2022, ['Bette Midler', 'Sarah Jessica Parker', 'Kathy Najimy'])
    
    title = removeFilm("Hocus Pocus 2")
    if title != '':
        print(title)
    else: print("Film not found")
    
    print(recursion(4,2))
    print(recursion(3,3))
    print(recursion(8,0))

if __name__ == "__main__":
    main()