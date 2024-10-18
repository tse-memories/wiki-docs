#!/bin/bash

# Navigate to the root folder
cd .

# Loop through each subfolder
for folder in */; do
    # Navigate into the subfolder
    cd "$folder"
    
    # Check if package.json exists
    if [ -f "package.json" ]; then
        echo "Updating prisma model in $folder"
        # Run npm i tse-memories-core@latest
        npm run prisma:db-pull
    else
        echo "No package.json found in $folder, skipping..."
    fi
    
    # Navigate back to the root folder
    cd ..
done
