import Link from 'next/link'
import Image from 'next/image'
import Form from '../component/form'
import '../css/home.css'

export default function Home() {
  return (
      <main className="hero container">
        <div className="hero-content">

          <nav>
            <div className="logo">
            <Image
              src="/images/logo2.png"
              priority={true}
              width={180} height={180} alt="Parky Logo"/>
            </div>

            <div className="links">
              <Link href="/">about</Link>
              <Link href="/">services</Link>
              <Link href="/">pricing</Link>
            </div>
          </nav>

          <h1>Search for you perfect parking slot</h1>

          <Form />
        </div>  
      </main>
  );
}
