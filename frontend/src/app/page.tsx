'use client'

import Link from 'next/link'
import Image from 'next/image'
import { useState } from 'react';
import Form from '../component/form';
import Slots from '../component/slots';
import { findSlots } from '../component/findSpots';

import '../css/global.css'

export default function Home() {

  const [slots, setSlots] = useState([]);
  const [showSlots, setShowSlots] = useState(false);

  const [_checkin, setCheckin] = useState("");
  const [_checkout, setCheckout] = useState("");

  const fetchSlots = async (checkinTime: string, checkoutTime: string) => {
    try {
      const response = await findSlots(checkinTime, checkoutTime);
      setSlots(response.slots);
      setShowSlots(true);
      setCheckin(response.checkinTime);
      setCheckout(response.checkoutTime);
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
              width={180} height={180} alt="Parky Logo"/>
            </div>

            <div className="links">
              <Link href="/">about</Link>
              <Link href="/">services</Link>
              <Link href="/">pricing</Link>
            </div>
          </nav>

          <h1>Search for you perfect parking slot</h1>

          <Form onFetchSlots={fetchSlots} />
        </div>  
      </main>
      {showSlots && <Slots data={slots} checkin={_checkin} checkout={_checkout} />}
    </>
  );
}
