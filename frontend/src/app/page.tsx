'use client'

import Link from 'next/link'
import Image from 'next/image'
import { useState } from 'react';
import Slots from '../component/slots';
import { findSlots } from '../component/findSlots';

import '../css/global.css'

export default function Home() {

  const [slots, setSlots] = useState([]);
  const [showSlots, setShowSlots] = useState(false);


  const fetchSlots = async () => {
    try {
      const response = await findSlots();
      console.log(response.slots);
      setSlots(response.slots);
      setShowSlots(true);
    } catch (error) {
      console.error('Error fetching slots data:', error);
    }
  };

  return (
    <>
      <main className="hero container">
        <div className="hero-content">
          <nav>
            <div className="logo">
              <Image
                src="/images/logo2.png"
                priority={true}
                width={180} height={180} alt="Parky Logo" />
            </div>

            <div className="links">
              <Link href="/">about</Link>
              <Link href="/">services</Link>
              <Link href="/">pricing</Link>
            </div>
          </nav>
          <h1>Search for you perfect parking slot</h1>
          <button className="search-btn" onClick={fetchSlots}>Find Slots</button>
          {/* <Form onFetchSlots={fetchSlots} /> */}
        </div>
      </main>
      {showSlots && <Slots data={slots} />}
    </>
  );
}
