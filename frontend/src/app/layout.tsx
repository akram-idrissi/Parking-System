export const metadata = {
  title: 'Next.js',
  description: 'Generated by Next.js',
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
