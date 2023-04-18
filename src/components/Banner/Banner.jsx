import { useEffect, useState } from 'react';

import { getMovies, categories } from '../../api';

import './Banner.css';

const imageHost = "https://image.tmdb.org/t/p/original"

export function Banner() {
    const [movie, setMovie] = useState({})

    const fetchRandomMovie = async (_path) => {
        try {
            const netflixOriginalsCategory = categories.find(
                (category) => category.name === "netflixOriginals"
            )

            const data = await getMovies(netflixOriginalsCategory.path)
            const movies = data?.results
            const randomIndex = Math.floor(Math.random() * movies.length)
            setMovie(movies[randomIndex])
        } catch (err) {
            console.log("ERRO: " + err)
        }
    }

    useEffect(() => {
        fetchRandomMovie()
    }, [])

    return (
        <header
            className='banner-container'
            style={{
                backgroundSize: 'cover',
                backgroundImage: `url(${imageHost + movie.backdrop_path})`,
                roundPosition: 'center-center',
                height: '2rem'
            }}
        >

        </header>
    )
}