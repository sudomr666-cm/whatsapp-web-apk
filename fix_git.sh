#!/bin/bash

echo "[+] Removing large files..."

git rm --cached swapfile 2>/dev/null
rm -f swapfile

echo "[+] Creating .gitignore..."

cat > .gitignore << 'EOL'
swapfile
*.apk
.gradle/
build/
local.properties
EOL

echo "[+] Commit fix..."

git add .
git commit -m "fix: remove large files and cleanup"

echo "[+] Force push..."

git push origin main --force

echo "[✓] DONE"
