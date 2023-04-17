import { useEffect } from 'react'
import axios from 'axios'

import getMovies from './api';

import './App.css'

function App() {
  const [count, setCount] = useState(0)

  useEffect( () => {

    let url =getMovies('trending')

      axios.get(url).then((data)=>{
        console.log(data)
      })

  } )

  return (
    <>App</>
  )
}

export default App
