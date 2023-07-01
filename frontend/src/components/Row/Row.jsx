import { useState, useEffect } from  'react'
import { getMovies } from '../../api';

import './Row.css'

const imageHost = "https://image.tmdb.org/t/p/original"

export function Row ({ title, path, isLarge }) {
    const [movies, setMovies] = useState([])

    const fetchMovies = async (_path) => {
       try {
        const data = await getMovies(_path);

        setMovies(data?.results) // apenas se data não for vazio
       } catch (error) {
        console.log('error Row: ', error)
       }

    }

    useEffect( () => {
        fetchMovies(path)
    }, [path] )

    return (
        <div className='row-container'>
            <h2 className='row-header'>{title}</h2>
            <div className='row-cards'>
                {movies?.map((movie) => {
                    return (
                        <img
                            className={`movie-card ${isLarge && "movie-card-large"}`}
                            key={movie.id}
                            src={imageHost + (isLarge?movie.backdrop_path:movie.poster_path)}
                            alt={movie.name}
                        ></img>
                    )
                })}
            </div>
        </div>
    )

}