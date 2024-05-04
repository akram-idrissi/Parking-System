export const metadata = {
  title: 'Parky',
  description: 'Smart parking system for all sort of vehicles (Cars, bikes, motorcycles, vans...)',
}

import localFont from 'next/font/local'
 
// Font files can be colocated inside of `app`
const myFont = localFont({
  src: '../../public/fonts/bubbleboddy_neue/bubbleboddyneue-regular.ttf',
  display: 'swap',
})

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en" className={myFont.className}>
      <body>{children}</body>
    </html>
  )
}
